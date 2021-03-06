package taller;
 
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;
import javax.servlet.annotation.WebServlet;
 
@WebServlet("/VehicleServlet")
public class VehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Obtain a database connection:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
 
        try {

            String model = request.getParameter("model");
            String matricula = request.getParameter("matricula");
            String problema = request.getParameter("problema");
            boolean estaArreglat = false;

            if (model != null && matricula != null && problema != null) {
                em.getTransaction().begin();
                em.persist(new Vehicle(model, matricula, problema, estaArreglat));
                em.getTransaction().commit();
            }

            List<Vehicle> vehicleList = em.createQuery(
                "SELECT g FROM Vehicle g", Vehicle.class).getResultList();
            request.setAttribute("vehicles", vehicleList);
            request.getRequestDispatcher("/vehicles.jsp")
                .forward(request, response);
 
        } finally {
            // Close the database connection:
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
    }

    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}