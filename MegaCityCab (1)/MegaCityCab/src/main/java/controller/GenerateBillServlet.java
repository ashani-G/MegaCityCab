package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.BillingDAO;

/**
 * Servlet implementation class GenerateBillServlet
 */
@WebServlet("/GenerateBillServlet")
public class GenerateBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookingIdStr = request.getParameter("bookingId");

        if (bookingIdStr == null) {
            response.sendRedirect("view_bookings.jsp?error=Invalid request");
            return;
        }

        int bookingId = Integer.parseInt(bookingIdStr);
        BillingDAO billingDAO = new BillingDAO();
        boolean success = billingDAO.generateBill(bookingId);

        if (success) {
            response.sendRedirect("view_bill.jsp?bookingId=" + bookingId);
        } else {
            response.sendRedirect("view_bookings.jsp?error=Failed to generate bill");
        }
    }



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
