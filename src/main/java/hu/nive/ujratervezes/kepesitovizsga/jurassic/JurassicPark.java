package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JurassicPark {
    private final DataSource ds;

    public JurassicPark(DataSource ds) {
        this.ds = ds;
    }

    public List<String> checkOverpopulation() {
        try (Connection conn = ds.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT breed FROM dinosaur WHERE expected < actual ORDER BY breed ASC;"
             )) {
            return getDinoNameListByPreparedStatement(ps);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    private List<String> getDinoNameListByPreparedStatement(PreparedStatement ps) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String name = rs.getString("breed");
                result.add(name);
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException("Wrong statement", e);
        }
    }

}
