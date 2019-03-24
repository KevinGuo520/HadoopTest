package com.mapreduce.flowcount;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * job �������
 * @author Administrator
 *
 */
public class FlowCountTask {

	public static void main(String[] args) throws Exception {
		
		// �������ö���
		Configuration conf = new Configuration();
		
		// job ����
		Job job = Job.getInstance(conf);
		
		// job ��
		job.setJarByClass(FlowCountTask.class);
		
		// mapper ��
		job.setMapperClass(FlowCountMapper.class);
		
		// reduce ��
		job.setReducerClass(FlowCountReduce.class);
		
		// mapper/reduce k-v
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(FlowBean.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FlowBean.class);
		
		// ���룬���·��
		FileInputFormat.setInputPaths(job, new Path("f:/mapreduce/flowcount/input/"));
		FileOutputFormat.setOutputPath(job, new Path("f:/mapreduce/flowcount/output/"));
		
		// ִ��
		boolean waitForCompletion = job.waitForCompletion(true);
		if (waitForCompletion) {
			System.out.println("--------------------------------successful--------------------------------");
		}else {
			System.out.println("================================failed=====================================");
		}
	}
}
