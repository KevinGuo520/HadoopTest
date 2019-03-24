package com.mapreduce.flowcount;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * 统计相同用户的流量
 * 
 * KEYIN: mapper 中的输出的key -- String
 * VALUEIN: mapper 中输出的值 -- FlowBean
 * KEYOUT: 输出的电话号码 -- String
 * VALUEOUT: 输出的FlowBean对象 -- FlowBean
 * 
 * @author Administrator
 *
 */
public class FlowCountReduce extends Reducer<Text, FlowBean, Text, FlowBean> {

	@Override
	protected void reduce(Text key, Iterable<FlowBean> values, Reducer<Text, FlowBean, Text, FlowBean>.Context context)
			throws IOException, InterruptedException {
		
		int up = 0;
		int down = 0;
		for (FlowBean flowBean : values) {
			up += flowBean.getUpFlow();
			down += flowBean.getDownFlow();
		}
		context.write(key, new FlowBean(up, down));
	}
}
