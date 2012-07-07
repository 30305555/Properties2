package jp.takemehisueha.prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/** 
 * Properties2 </br>
 *  property file read and Mapping
 * 
 * @author takemehisueha
 *
 */
public class Properties2 {
	
	/** 
	 * non visible Constructor
	 */
	private Properties2(){}
	/**
	 * -Djp.takemehisueha.prop.sysconfig1=<B><I>filename</I></B>
	 * -Djp.takemehisueha.prop.sysconfig2=<B><I>filename</I></B>
	 * -Djp.takemehisueha.prop.sysconfig3=<B><I>filename</I></B>
	 */
	private static final String SYSTEM_CONFIG1="jp.takemehisueha.prop.sysconfig1";
	private static final String SYSTEM_CONFIG2="jp.takemehisueha.prop.sysconfig2";
	private static final String SYSTEM_CONFIG3="jp.takemehisueha.prop.sysconfig3";
	
	private static final String[] configary = {SYSTEM_CONFIG1, SYSTEM_CONFIG2,SYSTEM_CONFIG3};
	/**
	 * static#getProperties</br>
	 * </br>
	 * Please appoint the hash map that a key has been set.</br>
	 * The setting of the value is unnecessary.</br>
	 * 
	 * @throws IOException  : prop read error. 
	 * @throws FileNotFoundException  : propfile not exitsts
	 */
	public static List<Properties>  getProperties() throws FileNotFoundException, IOException{

		Properties prop = null;
		List<Properties> proplist = new ArrayList<Properties>();

		for ( int i=0;i<configary.length; i++ ){
			
			// file input and prop load
			prop = getProperty(i);
			// list add
			proplist.add(prop);
		}
		// return List<Properties>
		return proplist;
	}
	/**
	 *  static#getProperty
	 * @param i getSystemProperty count
	 * @return Properties
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Properties getProperty(int i) throws FileNotFoundException, IOException{

		Properties prop = new Properties();
		try {
			// file input and prop load
			prop.load(new FileInputStream(System.getProperty(configary[i])));
		} catch (FileNotFoundException nofiles){
			nofiles.printStackTrace();
		}
		return prop;
	}
}
