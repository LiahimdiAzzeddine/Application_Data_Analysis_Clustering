package net.mongo.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import weka.classifiers.bayes.NaiveBayes;
import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

public class weka {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DataSource ds=new DataSource("src/main/java/net/mongo/api/model/dataset.arff");
		Instances ins=ds.getDataSet();
        SimpleKMeans model = new SimpleKMeans();
        //System.out.print(ins);
        model.setNumClusters(3);
        model.buildClusterer(ins);
        System.out.println(model);
        SerializationHelper.write("KMeans.model",model);
		/*
        System.out.println("s---------------------------------------------------------");

        List<TestD> list=new ArrayList<TestD>();
        SimpleKMeans Kmeans=(SimpleKMeans) SerializationHelper.read("KMeans.model");
        //System.out.println(model2);*/
        ClusterEvaluation eval = new ClusterEvaluation();
        DataSource src1 = new DataSource("src/main/java/net/mongo/api/model/dataset.arff");//test
        Instances tdt = src1.getDataSet();
        //Instance newInst=tdt.instance(3);
        //System.out.println(Kmeans.clusterInstance(newInst)+" New inst ");
        //System.out.println(newInst+" "+tdt.numInstances());
        /*int numIn=tdt.numInstances();
        for(int i=0;i<numIn;i++) {
        	Instance newIn=tdt.instance(i);
        	if((newIn.toString(0)).equals("'Malabata à              Tanger'")) {
        		TestD d=new TestD();
        		d.setLocal(newIn.toString(0));
        		d.setPrice(Double.parseDouble(newIn.toString(1)));
        		d.setSise(Integer.parseInt(newIn.toString(2)));
        		d.setCluster(Kmeans.clusterInstance(newIn));
                list.add(d);
                }
        }
        System.out.println(" "+list.get(1).toString());*/
    
        eval.setClusterer(model);
        eval.evaluateClusterer(tdt);
        System.out.println(eval.clusterResultsToString());
        System.out.println("# of clusters: " + eval.getNumClusters());
        		
	}

}
