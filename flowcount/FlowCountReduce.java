package com.mapreduce.flowcount;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * ͳ����ͬ�û�������
 * 
 * KEYIN: mapper �е������key -- String
 * VALUEIN: mapper �������ֵ -- FlowBean
 * KEYOUT: ����ĵ绰���� -- String
 * VALUEOUT: �����FlowBean���� -- FlowBean
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
