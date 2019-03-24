package com.mapreduce.flowcount;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

/**
 * ��������������Ϣ
 * @author Administrator
 *
 */
public class FlowBean implements Writable {

	private int upFlow;		// �û�����������
	private int downFlow;	// ����������������
	private int totalFlow;	// ������
	
	// �ղι��캯���� ���ڷ����л�
	public FlowBean() {
		
	}
	
	// ��ʼ��
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

	// ���л�
	@Override
	public void write(DataOutput out) throws IOException {
		
		out.writeInt(upFlow);
		out.writeInt(downFlow);
		out.writeInt(totalFlow);
	}
	
	// �����л�
	@Override
	public void readFields(DataInput in) throws IOException {
		
		this.upFlow = in.readInt();
		this.downFlow = in.readInt();
		this.totalFlow = in.readInt();
	}
	
	// ��дtoString
	@Override
	public String toString() {
		return upFlow + ", " + downFlow + ", " + totalFlow;
	}
}
