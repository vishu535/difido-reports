package il.co.topq.report.resource;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import il.co.topq.report.listener.ListenersManager;

@RestController
public class FileUploadResource {

	private final Logger log = LoggerFactory.getLogger(FileUploadResource.class);

	@RequestMapping(value = "/api/executions/{execution}/details/{uid}/file", method = RequestMethod.POST)
	public @ResponseBody void handleFileUpload(@PathVariable int execution,@PathVariable String uid, @RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				ListenersManager.INSTANCE.notifyFileAddedToTest(execution, uid, file.getBytes(),
						file.getOriginalFilename());
			} catch (IOException e1) {
				log.warn("Failed get content of file with name "+ file.getOriginalFilename());
			}
		}
	}

}