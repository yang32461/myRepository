package com.qst.userdrawmr;

import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import com.qst.userdrawmr.UserDrawMapReduce2.MyMap2;
import com.qst.userdrawmr.UserDrawMapReduce2.MyReduce2;
import com.qst.util.Config;
import com.qst.util.TextArrayWritable;

public class UserDrawMapReduce {
	public static Config cong = new Config();

	public static class MyMap extends
			Mapper<LongWritable, Text, Text, TextArrayWritable> {
		Text k = new Text();

		public void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			String line = value.toString();
			String[] dataArray = line.split(cong.Separator);
			String uiqkey = dataArray[Integer.parseInt(cong.MDN)]
						+ dataArray[Integer.parseInt(cong.appID)]; // MDN + appID
			String[] val = new String[5];
			String timenow = dataArray[Integer.parseInt(cong.Date)];
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			val[0] = sdf.format(Long.parseLong(timenow));//时间
			val[1] = dataArray[Integer.parseInt(cong.MDN)];// 手机号
			val[2] = dataArray[Integer.parseInt(cong.appID)];// appID
			val[3] = "1";// 计数
			val[4] = dataArray[Integer.parseInt(cong.ProcedureTime)];// 使用时长
			k.set(uiqkey);
			context.write(k, new TextArrayWritable(val));

		}
	}

	public static class MyReduce extends
			Reducer<Text, TextArrayWritable, NullWritable, Text> {
		Text v = new Text();
		
		
		public void reduce(Text key, Iterable<TextArrayWritable> values,
				Context context) throws IOException, InterruptedException {
			long sum = 0;
			int count = 0;
			String[] res = new String[5];
			
			for (TextArrayWritable t : values) {
				String[] vals = t.toStrings();
				
					res = vals;
				
				if (vals[3] != null) {
					count = count + 1;

				}
				if (vals[4] != null) {
					sum += Long.valueOf(vals[4]);
				}
			}
			res[3] = String.valueOf(count);
			res[4] = String.valueOf(sum);

			StringBuffer sb = new StringBuffer();
			sb.append(res[0]).append("|");// 时间
			sb.append(res[1]).append("|");// 手机号
			sb.append(res[2]).append("|");// appID
			sb.append(res[3]).append("|");// 计数
			sb.append(res[4]);// 使用时长
			v.set(sb.toString());
			context.write(null, v);
		}
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		//获取job实例
		Job job1 = Job.getInstance(conf, "UserDrawMapReduceJob1");
		//定义入口函数所在的类
		job1.setJarByClass(UserDrawMapReduce.class);

		job1.setMapperClass(MyMap.class);
		job1.setReducerClass(MyReduce.class);

		job1.setMapOutputKeyClass(Text.class);
		job1.setMapOutputValueClass(TextArrayWritable.class);
		job1.setOutputKeyClass(Text.class);
		job1.setOutputValueClass(Text.class);

		job1.setInputFormatClass(TextInputFormat.class);
		job1.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job1, new Path(args[0]));// 输入路径
		FileOutputFormat.setOutputPath(job1, new Path(args[1]));// 输出路径

		Boolean state1 = job1.waitForCompletion(true);//将job1执行的情况返回给用户
		System.out.println("job1执行成功！！！");
		
			if (state1) {
				conf = new Configuration();
				Job job2 = Job.getInstance(conf, "UserDrawMapReduceJob2");
				job2.setJarByClass(UserDrawMapReduce.class);

				job2.setMapperClass(MyMap2.class);
				job2.setReducerClass(MyReduce2.class);

				job2.setMapOutputKeyClass(Text.class);
				job2.setMapOutputValueClass(Text.class);
				job2.setOutputKeyClass(Text.class);
				job2.setOutputValueClass(Text.class);

				job2.setInputFormatClass(TextInputFormat.class);
				job2.setOutputFormatClass(TextOutputFormat.class);

				FileInputFormat.addInputPath(job2, new Path(args[1]));// 输入路径
				FileOutputFormat.setOutputPath(job2, new Path(args[2]));// 输出路径

				Boolean state2 = job2.waitForCompletion(true);
				System.out.println("job2执行成功！！！");
				System.exit(job2.waitForCompletion(true)? 0:1);
				
		}
	}
}
