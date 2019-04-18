package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Quiz;


@WebServlet("/QuizJspServlet")
public class QuizJspServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int currentQuestionNo = 0;
        int score = 0;
        Quiz quiz = (Quiz) session.getAttribute("quiz");
        if (quiz == null) {
            quiz = new Quiz();
            session.setAttribute("currentQuestion", currentQuestionNo);
            session.setAttribute("quiz", quiz);
            session.setAttribute("score", score);
        } else {
            String answer = request.getParameter("answer");
            currentQuestionNo = (Integer) session.getAttribute("currentQuestion");
            if (quiz.getAnswers()[currentQuestionNo] == Integer.parseInt(answer)) {
                score = (Integer) session.getAttribute("score") + 1;
                session.setAttribute("score", score);
            }
            currentQuestionNo++;
            session.setAttribute("currentQuestion", currentQuestionNo);
        }

        if (currentQuestionNo == quiz.getQuestions().length) {
            session.invalidate();
            request.setAttribute("length", quiz.getQuestions().length);
            request.setAttribute("score", score);
            request.getRequestDispatcher("result.jsp").forward(request, response);
        } else {
            System.out.println(quiz.getQuestions()[currentQuestionNo]);
            session.setAttribute("currentQuiz", quiz.getQuestions()[currentQuestionNo]);
            request.getRequestDispatcher("quiz.jsp").forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

