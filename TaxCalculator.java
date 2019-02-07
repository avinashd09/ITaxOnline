import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaxCalculator extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
    
        String s1=req.getParameter("t1");
        String s2=req.getParameter("t2");
        String s3[]=req.getParameterValues("assets");       
        String s4=req.getParameter("c1");
        int INCOME=Integer.parseInt(s1);
        int AGE=Integer.parseInt(s2);
        int tax=0,rebate=0,surcharge=0,nri_chrg=0,net_tax=0;
       
        if(INCOME>=500000)
        {
        tax=(INCOME*20)/100;
        }
        else
        {
        tax=(INCOME*10)/100;
        }
        if(AGE>=60)
        {
        rebate=(tax*10)/100;
        }
        else
        {
        rebate=(tax*5)/100;
        }
        net_tax=tax-rebate;
        if(s3!=null)
        {
            surcharge=s3.length*500;
        }
        if(s4!=null)
        {
        nri_chrg=5000;
        }
        
    PrintWriter out=resp.getWriter();
    out.println("THANKS FOR CHOOSING US");
    out.println("YOUR TAXABLE AMT IS " +tax);
    out.println("YOU GOT A REBATE OF " +rebate);
    out.println("YOUR NET TAXABLE AMT IS " +net_tax);
    out.println("YOUR SURCHARGE AMT IS " +surcharge);
    out.println("NRI CHARGE " +nri_chrg);
    out.close();
    }    
}
