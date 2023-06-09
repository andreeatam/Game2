package GUI;

import Model.User;
import Operation.Operations;
import Results.Result;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Controller implements ActionListener {
    private final View view;
    private boolean isBAdunareClicked, isBScadereClicked, isBInmultireClicked;
    private boolean isBImpartireClicked, isBDerivareClicked, isBIntegrareClicked;
    private boolean isBValidClicked, isBRankingClicked, isBTokensClicked, isBClasamentClicked;
    private final Operations op = new Operations();
    public static User user = new User();
    final String DB_URL = "jdbc:mysql://localhost:3306/game";
    final String USERNAME = "root";
    final String PASSWORD = "Andreea31!";


    public Controller(View v) {
        this.view = v;
    }


    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        boolean areRaspCorect = false;

        view.bAdunare.addActionListener(this);
        view.bScadere.addActionListener(this);
        view.bInmultire.addActionListener(this);
        view.bImpartire.addActionListener(this);
        view.bDerivare.addActionListener(this);
        view.bIntegrare.addActionListener(this);

        view.bValidRasp.addActionListener(this);
        view.bRanking.addActionListener(this);
        view.bTokens.addActionListener(this);
        view.bClasament.addActionListener(this);

        if (e.getSource() == view.bAdunare) {
            isBAdunareClicked = true;
        } else if (e.getSource() == view.bScadere) {
            isBScadereClicked = true;
        } else if (e.getSource() == view.bInmultire) {
            isBInmultireClicked = true;
        } else if (e.getSource() == view.bImpartire) {
            isBImpartireClicked = true;
        } else if (e.getSource() == view.bDerivare) {
            isBDerivareClicked = true;
        } else if (e.getSource() == view.bIntegrare) {
            isBIntegrareClicked = true;
        } else if (e.getSource() == view.bValidRasp) {
            isBValidClicked = true;
        } else if (e.getSource() == view. bRanking) {
            isBRankingClicked = true;
        } else if (e.getSource() == view.bTokens) {
            isBTokensClicked = true;
        } else if (e.getSource() == view.bClasament) {
            isBClasamentClicked = true;
        } else {
            return;
        }


        if (isBValidClicked) { //e true
            if (isBAdunareClicked) {
                view.setRaspunsCorect1(op.aduna(view.gettPolinom1(), view.gettPolinom2()));
                if (view.getRaspunsCorect1().toString().equals(view.getRezUser().toString())) {
                    JOptionPane.showMessageDialog(null, "Raspuns corect");
                    user.setTokens(user.getTokens() + 2);
                    user.setRanking(user.getRanking() + 2);
                    areRaspCorect = true;
                } else
                    JOptionPane.showMessageDialog(null, "Raspuns incorect, " + " corect este: " + op.aduna(view.gettPolinom1(), view.gettPolinom2()).toString());
                isBAdunareClicked = false; //resetam flag urile


            } else if (isBScadereClicked) {
                view.setRaspunsCorect1(op.scadere(view.gettPolinom1(), view.gettPolinom2()));
                if (view.getRaspunsCorect1().toString().equals(view.getRezUser().toString())) {
                    JOptionPane.showMessageDialog(null, "Raspuns corect");
                    user.setTokens(user.getTokens() + 2);
                    user.setRanking(user.getRanking() + 2);
                    areRaspCorect = true;
                } else
                    JOptionPane.showMessageDialog(null, "Raspuns incorect, " + " corect este: " + op.scadere(view.gettPolinom1(), view.gettPolinom2()).toString());
                isBScadereClicked = false;


            } else if (isBInmultireClicked) {
                view.setRaspunsCorect1(op.inmultire(view.gettPolinom1(), view.gettPolinom2()));
                if (view.getRaspunsCorect1().toString().equals(view.getRezUser().toString())) {
                    JOptionPane.showMessageDialog(null, "Raspuns corect");
                    user.setTokens(user.getTokens() + 5);
                    user.setRanking(user.getRanking() + 5);
                    areRaspCorect = true;
                } else
                    JOptionPane.showMessageDialog(null, "Raspuns incorect, " + " corect este: " + op.inmultire(view.gettPolinom1(), view.gettPolinom2()).toString());
                isBInmultireClicked = false; //resetam flag urile


            } else if (isBImpartireClicked) {
                Result rez = op.impartire(view.gettPolinom1(), view.gettPolinom2());
                view.setRaspunsCorect1(rez.cat);
                view.setRaspunsCorect2(rez.rest);
                if ((view.getRaspunsCorect1().toString().equals(view.getRezUser().toString())) && (view.getRaspunsCorect2().toString().equals(view.getRezUser2().toString()))) {
                    JOptionPane.showMessageDialog(null, "Raspuns corect");
                    user.setTokens(user.getTokens() + 8);
                    user.setRanking(user.getRanking() + 8);
                    areRaspCorect = true;
                } else
                    JOptionPane.showMessageDialog(null, "Raspuns incorect, " + " corect este: " + "cat: " + view.getRaspunsCorect1().toString() + " ,rest: " + view.getRaspunsCorect2().toString());
                isBImpartireClicked = false; //resetam flag urile


            } else if (isBDerivareClicked) {
                view.setRaspunsCorect1(op.derivare(view.gettPolinom1()));
                view.setRaspunsCorect2(op.derivare(view.gettPolinom2()));
                if ((view.getRaspunsCorect1().toString().equals(view.getRezUser().toString())) && (view.getRaspunsCorect2().toString().equals(view.getRezUser2().toString()))) {
                    JOptionPane.showMessageDialog(null, "Raspuns corect");
                    user.setTokens(user.getTokens() + 6);
                    user.setRanking(user.getRanking() + 6);
                    areRaspCorect = true;
                } else
                    JOptionPane.showMessageDialog(null, "Raspuns incorect, " + " corect este P1: " + op.derivare(view.gettPolinom1()) + " ,P2: " + op.derivare(view.gettPolinom2()));
                isBDerivareClicked = false; //resetam flag urile


            } else if (isBIntegrareClicked) {
                view.setRaspunsCorect1(op.integrare(view.gettPolinom1()));
                view.setRaspunsCorect2(op.integrare(view.gettPolinom2()));
                if ((view.getRaspunsCorect1().toString().equals(view.getRezUser().toString())) && (view.getRaspunsCorect2().toString().equals(view.getRezUser2().toString()))) {
                    JOptionPane.showMessageDialog(null, "Raspuns corect");
                    user.setTokens(user.getTokens() + 8);
                    user.setRanking(user.getRanking() + 8);
                    areRaspCorect = true;
                } else
                    JOptionPane.showMessageDialog(null, "Raspuns incorect, " + " corect este P1: " + op.integrare(view.gettPolinom1()) + " P2: " + op.integrare(view.gettPolinom2()));
                isBIntegrareClicked = false; //resetam flag urile
            }

            if (areRaspCorect) {
                updateScorInDB();
                areRaspCorect = false;
            }
            isBValidClicked = false;
            view.bValidRasp.removeActionListener(this);

        }

        if (isBRankingClicked) {
            getRankingFromDB();
            isBRankingClicked = false;
            view.bRanking.removeActionListener(this);
        }

        if (isBTokensClicked) {
            getTokensFromDB();
            isBTokensClicked = false;
            view.bTokens.removeActionListener(this);
        }

        if (isBClasamentClicked) {
            //showFirst5Users();
            isBClasamentClicked = false;
            view.bClasament.removeActionListener(this);
        }

    }


    public void getRankingFromDB() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); //connection succesfully

            Statement stmt = conn.createStatement();
            String sql = "SELECT ranking FROM Users WHERE username=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.username);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                String returnedNumber=result.getString("ranking");
                JOptionPane.showMessageDialog(null, "Rankingul tau este: " + returnedNumber);

            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getTokensFromDB() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); //connection succesfully

            Statement stmt = conn.createStatement();
            String sql = "SELECT tokens FROM Users WHERE username=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.username);

            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                String returnedNumber=result.getString("tokens");
                JOptionPane.showMessageDialog(null, "Nr total de tokens acumulati este:  " + returnedNumber);
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateScorInDB(){
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD); //connection succesfully

            Statement stmt = conn.createStatement();
            String sql = "UPDATE Users SET tokens=?, ranking=? WHERE username=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, String.valueOf(user.getTokens()));
            preparedStatement.setString(2, String.valueOf(user.getRanking()));
            preparedStatement.setString(3, String.valueOf(user.username));

            System.out.println(preparedStatement);

            int rowsUpdated= preparedStatement.executeUpdate();
            if(rowsUpdated>0){
                System.out.println("Scorul a fost actualizat!");
            }

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
