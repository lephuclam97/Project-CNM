package realtime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.letsstartcoding.springbootrestapiexample.dao.RequestDAO;
import com.letsstartcoding.springbootrestapiexample.model.Request;

@Controller
public class GreetingController {
	
	RequestDAO DAO;

	@MessageMapping("/realtime")
    @SendTo("/topic/greetings")
    public Request greeting(Request req) throws Exception {
        Thread.sleep(1000); // simulated delay
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//        List <Request> listReq= DAO.findAll();
        
//        for(int i=0; i< listReq.size();i++) {
//        	if(req.getId_request()== listReq.get(i).getId_request()) {
//        		
//        	}
//        }    
//		Collections.sort(listReq);
		
//		Date today = Calendar.getInstance().getTime();       
//        HtmlUtils.htmlEscape(Long.toString(req.getId_request())) +
        return req;
    }

}