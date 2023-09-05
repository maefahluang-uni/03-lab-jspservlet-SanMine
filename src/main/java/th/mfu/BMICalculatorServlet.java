package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        //TODO: calculate bmi
        Double w = Double.parseDouble(weight);
        Double h = Double.parseDouble(height);
        int bmi = (int) Math.round(w/(h*h));
       
        //TODO: determine the built from BMI
        String result = "";
        if(bmi < 18.5){
           result = "underweight";
        }
        else if(18.5 <= bmi && bmi< 25){
           result = "normal"; 
        }
        else if (25 <= bmi && bmi <30){
          result = "overweight";
        }
        else if ( 30 <= bmi && bmi < 35){
          result = "obese";
        }
        else if( bmi >= 35){
           result = "extremely obese";
        }

            
        //TODO: add bmi and built to the request's attribute

        
        request.setAttribute("BMI", bmi);
        request.setAttribute("Result" , result);

        //TODO: forward to jsp
           request.getRequestDispatcher("bmi_result.jsp").forward(request,response);
    }
    
}
