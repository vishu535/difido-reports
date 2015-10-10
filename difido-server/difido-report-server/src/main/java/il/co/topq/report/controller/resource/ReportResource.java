package il.co.topq.report.controller.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import il.co.topq.report.model.ExecutionManager;
import il.co.topq.report.model.ExecutionManager.ExecutionMetaData;

@Path("/reports")
public class ReportResource {

	private static final Logger log = LoggerFactory.getLogger(ExecutionResource.class);


	/**
	 * Get list of all the reports
	 * 
	 * @param execution
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ExecutionMetaData[] get(@PathParam("execution") int execution) {
		log.debug("GET - Get all reports");
		return ExecutionManager.INSTANCE.getAllMetaData();
	}

}