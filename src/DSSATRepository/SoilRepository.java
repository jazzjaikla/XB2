package DSSATRepository;

import Extensions.Variables;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import xbuild.ExtendFilter;

/**
 *
 * @author Jazzy
 */
public class SoilRepository extends DSSATRepositoryBase {
    
    public SoilRepository(String rootPath) {
        super(rootPath);
    }
    
    @Override
    public ArrayList<String> Parse() throws IOException {

        ArrayList<String> soilList = new ArrayList<>();
        
        try {
            File sPath = new File(rootPath + "\\Soil");
            File soilFileList[] = sPath.listFiles(new ExtendFilter(".sol"));
            
            for (File sFile : soilFileList) {
                FileReader fileRead = new FileReader(sFile);
                BufferedReader sReader = new BufferedReader(fileRead);

                String strRead = "";
                Boolean isProfile = false;
                while ((strRead = sReader.readLine()) != null) {
                    if(strRead != null && !"".equals(strRead)){
                        if(strRead.startsWith("*") && !strRead.toLowerCase().startsWith("*soils") && strRead.length() > 36){
                            String soilCode = strRead.substring(1, 11).trim();
                            String soilDescription = strRead.length() <= 36 ? soilCode : strRead.substring(37, strRead.length()).trim();
                            soilList.add(soilCode + ":" + soilDescription);
                            isProfile = false;
                        }
                        else if(strRead.startsWith("@  SLB") && !isProfile){
                            isProfile = true;
                        }
                        else if(strRead.startsWith("@  SLB") && isProfile){
                            isProfile = false;
                        }
                        else if(!strRead.startsWith("!") && strRead.length() >= 90 && isProfile){
                            int index = soilList.size() - 1;
                            if(index >= 0){
                                String tmp = soilList.get(index);
                                tmp += "|" + strRead;
                                try{
                                    soilList.set(index, tmp);
                                }
                                catch(Exception ex){
                                    soilList.set(index, "jj");
                                    throw ex;
                                }
                            }
                        }
                    }
                    else{
                        isProfile = false;
                    }
                        
                }
                fileRead.close();
                sReader.close();
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        return soilList;
    }
}
