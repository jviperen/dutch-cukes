package cukes.dutch.driver.utils;

import cukes.dutch.driver.exceptions.CouldNotReadDriverFromLocalProperty;
import cukes.dutch.driver.exceptions.CouldNotReadFromPomException;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.project.MavenProject;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyLoader {

	public PropertyLoader() {
		super();
	}


	public void logMessage(Level levelLogging, String message) {
		Logger.getLogger(PropertyLoader.class.getName()).log(levelLogging, message);
	}

	public String loadLocalProperty(String propertyName) throws IOException {
		Properties prop = new Properties();
		prop.load(PropertyLoader.class.getClassLoader().getResourceAsStream(
				"local.properties"));

		logMessage(Level.INFO, "Local property " + propertyName.toUpperCase() + " is loaded with : \n"
				+ prop.getProperty(propertyName) + "\n");

		return prop.getProperty(propertyName);
	}

	public String getPomProperty(String propertyPom) throws CouldNotReadFromPomException {
		String pompProperty = null;
		Model model = null;
		FileReader reader = null;
		File pomFile = new File("pom.xml");
		MavenXpp3Reader mavenReader = new MavenXpp3Reader();

		try {
		     reader = new FileReader(pomFile);
		     model = mavenReader.read(reader);
		     model.setPomFile(pomFile);
		}catch(Exception ex){
            throw new CouldNotReadFromPomException("We couldn't read from pomfile ", ex);
        }

		MavenProject project = new MavenProject(model);


		if (System.getProperty(propertyPom) == null){
			pompProperty = project.getProperties().getProperty(propertyPom);
		} else{
			pompProperty = System.getProperty(propertyPom);
		}
		return pompProperty;
	}

    public String getLocalDriverBinary(String driver) throws CouldNotReadDriverFromLocalProperty {
        String driverBinary = null;
        String binaryLocationDriver = driver + ".binary.location";
        try {
            driverBinary = loadLocalProperty(binaryLocationDriver);
        } catch (IOException e) {
            {
                throw new CouldNotReadDriverFromLocalProperty("We couldn't read from local.properties, tried to read "
                    + driver + " with binary " + binaryLocationDriver.toUpperCase(), e); }
        }
        return driverBinary;
    }

}
