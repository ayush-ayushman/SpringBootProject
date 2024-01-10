package com.ty.config;
import java.io.Reader;
import javax.sql.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.ty.model.User;

@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public FlatFileItemReader<User> reader()
	{
		FlatFileItemReader<User> reader=new FlatFileItemReader<>();
		reader.setResource(new ClassPathResource("Book1.csv"));
		reader.setLineMapper(getLineMapper());
		reader.setLinesToSkip(1);
		return reader;
	}

	private LineMapper<User> getLineMapper() {
		 DefaultLineMapper<User> mp=new DefaultLineMapper<>();
		 BeanWrapperFieldSetMapper<User> fieldSetter= new BeanWrapperFieldSetMapper<>();
		 DelimitedLineTokenizer lineTokenizer=new DelimitedLineTokenizer();
		 lineTokenizer.setNames(new String[] {"id","name","email","city","phone"});
		 lineTokenizer.setIncludedFields(new int[]{0,1,2,3});
		 fieldSetter.setTargetType(User.class);
		 mp.setLineTokenizer(lineTokenizer);
		 mp.setFieldSetMapper(fieldSetter);
		return mp;
		
	}
	@Bean
	public UserItemProcessor processor()
	{
		return new UserItemProcessor();
		
	}
	@Bean
	public JdbcBatchItemWriter<User> writer()
	{
		JdbcBatchItemWriter<User> writer=new JdbcBatchItemWriter<>();
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<User>());
		writer.setSql("insert into user(id,name,email,city,phone)values(:id,:name,:email,:city,:phone)");
		return writer ;
		
	}
	@Bean
	public Job importUserJob()
	{
		return this.jobBuilderFactory.get("USER-IMPORT-JOB").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
		
		
	}
    @Bean
	public Step step1() {
	return	this.stepBuilderFactory.get("step1")
		.<User,User>chunk(5)
		.reader(reader())
		.processor(processor())
		.writer(writer())
		.build();
		
	}
	
	

}
