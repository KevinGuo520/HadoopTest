package com.mapreduce.flowcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * 每次处理一行
 * KEYIN: 每一行偏移量 -- long
 * VALUEIN: 每一行的内容 -- String
 * KEYOUT: 键值对中的键 -- String
 * VALUEOUT: 键值对中的值 -- FlowBean
 * 
 * @author Administrator
 *
 */
public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		// 以空格开分割
		String[] words = line.split("\t");
		int up = Integer.parseInt(words[words.length-5]);
		int down = Integer.parseInt(words[words.length-4]);
		context.write(new Text(words[1]), new FlowBean(up, down));
	}
}
