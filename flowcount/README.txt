Hadoop-2.8.5 版本的mapreduce练习

flow.txt 为该程序的练习数据集

FileInputFormat.setInputPaths(job, new Path("f:/mapreduce/flowcount/input/"));
FileOutputFormat.setOutputPath(job, new Path("f:/mapreduce/flowcount/output/"));
这两句代码中的路径根据需要改动。

Hadoop-2.8.5 在windows上编译后的包在库中可以找到。
