package net.mongo.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import net.mongo.api.model.KmeansClass;
import net.mongo.api.model.ModeleKmeans;
import net.mongo.api.repository.AppartementRepository;
import weka.clusterers.SimpleKMeans;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.ConverterUtils.DataSource;

@CrossOrigin
@RestController
public class KmeansController {
	@Autowired
    private AppartementRepository rep;
	  @CrossOrigin(origins = "http://localhost:4200")
	    @ResponseStatus(HttpStatus.CREATED)
		@PutMapping("/addModele")
	    public  List<String> saveUtilisateur(@RequestBody ModeleKmeans m) throws Exception {
			List<String> myArrayList = new ArrayList<>();
	    	DataSource ds=new DataSource("src/main/java/net/mongo/api/model/dataset.arff");
			Instances ins=ds.getDataSet();
	        SimpleKMeans model = new SimpleKMeans();
	        model.setNumClusters(3);
	        model.buildClusterer(ins);
	        SerializationHelper.write(m.getNom()+".model",model);
	        myArrayList.add("Nom de Modele:"+m.getNom());
	        myArrayList.add("Nombre des clusters :"+model.getNumClusters());
	        myArrayList.add("squared errors :"+model.getSquaredError());
	        myArrayList.add("Nombre d'iterations :"+model.getMaxIterations());
	        myArrayList.add("Premier centroid :"+model.getClusterCentroids().instance(0).toString());
	        myArrayList.add("Deuxième centroid:"+model.getClusterCentroids().instance(1).toString());
	        myArrayList.add("Troisième centroid :"+model.getClusterCentroids().instance(2).toString());
	    	return myArrayList;
	    }
	    @GetMapping("/Kmeans")
	    public List<KmeansClass> Kmeans() throws Exception{
	    	List<KmeansClass> list=new ArrayList<KmeansClass>();
	        SimpleKMeans Kmeans=(SimpleKMeans) SerializationHelper.read("KMeans.model");
	    	DataSource src1 = new DataSource("src/main/java/net/mongo/api/model/dataset.arff");//test
	        Instances tdt = src1.getDataSet();
	                
	        //ajouter les centroids
	        for(int o=0;o<3;o++) {
	        	KmeansClass centroids=new KmeansClass();
	        	double p=Double.parseDouble(Kmeans.getClusterCentroids().instance(o).toString(1));
	        	int size=(int) Double.parseDouble(Kmeans.getClusterCentroids().instance(o).toString(2));
	        	centroids.setLocal("centroid");
	        	centroids.setPrice(p);
	        	centroids.setSise(size);;
	        	list.add(centroids);

	        }
	       
	        int numIn=tdt.numInstances();
	        for(int i=0;i<numIn;i++) {
	        	Instance newIn=tdt.instance(i);
	        		KmeansClass d=new KmeansClass();
	        		d.setLocal(newIn.toString(0));
	        		d.setPrice(Double.parseDouble(newIn.toString(1)));
	        		d.setSise(Integer.parseInt(newIn.toString(2)));
	        		d.setCluster(Kmeans.clusterInstance(newIn));
	                list.add(d);
	        }
	        //trier selon le prix
	        for(int j=0;j<numIn;j++) {
	        	KmeansClass temp;
	        	for(int k=0;k<numIn;k++) {
	            	if(list.get(j).getPrice()<list.get(k).getPrice()) {
	            		temp=list.get(j);
	            		list.set(j, list.get(k));
	            		list.set(k, temp);
	            		k--;
	            	}
	            }	
	        }	        
	    	return list;
	    }

}
