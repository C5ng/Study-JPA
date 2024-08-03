package c5ng.data_jpa.repository;

public interface NestedClosedProjections {
    String getUsername();

    TeamInfo getTeam();

    interface TeamInfo {
        String getName();
    }
}
