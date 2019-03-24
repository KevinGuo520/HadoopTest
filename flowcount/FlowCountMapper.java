package com.mapreduce.flowcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * ÿ�δ���һ��
 * KEYIN: ÿһ��ƫ���� -- long
 * VALUEIN: ÿһ�е����� -- String
 * KEYOUT: ��ֵ���еļ� -- String
 * VALUEOUT: ��ֵ���е�ֵ -- FlowBean
 * 
 * @author Administrator
 *
 */
public class FlowCountMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		// �Կո񿪷ָ�
		String[] words = line.split("\t");
		int up = Integer.parseInt(words[words.length-5]);
		int down = Integer.parseInt(words[words.length-4]);
		context.write(new Text(words[1]), new FlowBean(up, down));
	}
}
