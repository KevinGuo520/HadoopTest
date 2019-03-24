package com.mapreduce.flowcount;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * job 任务调度
 * @author Administrator
 *
 */
public class FlowCountTask {

	public static void main(String[] args) throws Exception {
		
		// 创建配置对象
		Configuration conf = new Configuration();
		
		// job 对象
		Job job = Job.getInstance(conf);
		
		// job 类
		job.setJarByClass(FlowCountTask.class);
		
		// mapper 类
		job.setMapperClass(FlowCountMapper.class);
		
		// reduce 类
		job.setReducerClass(FlowCountReduce.class);
		
		// mapper/reduce k-v
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(FlowBean.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FlowBean.class);
		
		// 输入，输出路径
		FileInputFormat.setInputPaths(job, new Path("f:/mapreduce/flowcount/input/"));
		FileOutputFormat.setOutputPath(job, new Path("f:/mapreduce/flowcount/output/"));
		
		// 执行
		boolean waitForCompletion = job.waitForCompletion(true);
		if (waitForCompletion) {
			System.out.println("--------------------------------successful--------------------------------");
		}else {
			System.out.println("================================failed=====================================");
		}
	}
}
