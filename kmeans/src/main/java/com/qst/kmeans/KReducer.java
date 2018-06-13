package com.qst.kmeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class KReducer extends Reducer<IntWritable, Text, Text, Text> {

	/**
	 * 1.Key为聚类中心的ID value为该中心的记录集合 2.计数所有记录元素的平均值，求出新的中心
	 */
	protected void reduce(IntWritable key, Iterable<Text> value, Context context)
			throws IOException, InterruptedException {
		ArrayList<ArrayList<Double>> filedsList = new ArrayList<ArrayList<Double>>();

		// 依次读取记录集，每行为一个ArrayList<Double>
		for (Iterator<Text> it = value.iterator(); it.hasNext();) {
			ArrayList<Double> tempList = Utils.textToArray(it.next());
			filedsList.add(tempList);
		}

		// 计算新的中心
		// 每行的元素个数
		int filedSize = filedsList.get(0).size();
		double[] avg = new double[filedSize];
		for (int i = 0; i < filedSize; i++) {
			// 求没列的平均值
			double sum = 0;
			int size = filedsList.size();
			for (int j = 0; j < size; j++) {
				sum += filedsList.get(j).get(i);
			}
			avg[i] = sum / size;
		}
		context.write(new Text(""), new Text(Arrays.toString(avg).replace("[", "").replace("]", "")));
	}

}
