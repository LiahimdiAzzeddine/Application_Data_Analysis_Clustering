package net.mongo.api.model;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

public class EN {

	public static void main(String[] args) throws Exception {
		DataSource ds=new DataSource("src/main/java/net/mongo/api/model/dataset.arff");
		Instances ins=ds.getDataSet();
		EM EM=new EM();
		EM.buildClusterer(ins);
		System.out.print(EM);
		SerializationHelper.write("EM.model",EM);
		/*
		ClusterEvaluation eval = new ClusterEvaluation();
		eval.setClusterer(EM);
		eval.evaluateClusterer(ins);

		System.out.println(eval.clusterResultsToString()+"OK");*/

	}

}
