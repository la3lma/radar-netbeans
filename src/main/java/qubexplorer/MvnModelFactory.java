package qubexplorer;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.netbeans.api.project.Project;
import org.openide.filesystems.FileObject;

/**
 *
 * @author Victor
 */
public class MvnModelFactory {
    
    public Model createModel(Project project) throws IOException{
        return createModel(project.getProjectDirectory().getFileObject("pom.xml"));
    }
    
    public Model createModel(FileObject pomFile) throws IOException{
        Model model = null;
        MavenXpp3Reader mavenreader = new MavenXpp3Reader();
        try {
            model = mavenreader.read(new InputStreamReader(pomFile.getInputStream()));
            model.setPomFile(new File(pomFile.getPath()));
            return model;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
}