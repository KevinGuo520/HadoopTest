package com.mapreduce.flowcount;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

/**
 * 用来储存流量信息
 * @author Administrator
 *
 */
public class FlowBean implements Writable {

	private int upFlow;		// 用户发出的流量
	private int downFlow;	// 服务器发出的流量
	private int totalFlow;	// 总流量
	
	// 空参构造函数， 用于反序列化
	public FlowBean() {
		
	}
	
	// 初始化
	public FlowBean(int upFlow, int downFlow) {
		this.upFlow = upFlow;
		this.downFlow = downFlow;
		this.totalFlow = this.upFlow + this.downFlow;
	}
	

	public int getUpFlow() {
		return upFlow;
	}

	public int getDownFlow() {
		return downFlow;
	}

	// 序列化
	@Override
	public void write(DataOutput out) throws IOException {
		
		out.writeInt(upFlow);
		out.writeInt(downFlow);
		out.writeInt(totalFlow);
	}
	
	// 反序列化
	@Override
	public void readFields(DataInput in) throws IOException {
		
		this.upFlow = in.readInt();
		this.downFlow = in.readInt();
		this.totalFlow = in.readInt();
	}
	
	// 重写toString
	@Override
	public String toString() {
		return upFlow + ", " + downFlow + ", " + totalFlow;
	}
}
