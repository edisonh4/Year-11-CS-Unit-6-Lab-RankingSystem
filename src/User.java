public class User {
    private int rank;
    private int rankProgress;

    public User() {
        rank = -8;
        rankProgress = 0;
    }

    public int getRank() {
        return rank;
    }
    public int getProgress() {
        return rankProgress;
    }

    public void incProgress(int rankOfProblem){
        if (rankOfProblem < -8|| rankOfProblem == 0|| rankOfProblem >8){
             throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        if (rankOfProblem < rank){
            rankProgress = rankProgress + 1;
        }
        else if (rankOfProblem == rank){
            rankProgress = rankProgress+3;}
        else if (rankOfProblem > rank){
            if (rankOfProblem > 0 && rank < 0) {
                rankProgress += 10 * (rankOfProblem - rank - 1) * (rankOfProblem - rank - 1);
            }
            else
                rankProgress += 10 * (rankOfProblem - rank) * (rankOfProblem - rank);
        }
        while (rankProgress >= 100) {
            if (rank == -1) {
                rank = 1;
            } else {
                rank++;
            }
            rankProgress = rankProgress - 100;
        }
    }

    public String toString() {
        return "User{rank=" + rank + ", progress=" + rankProgress + '}';
    }

}
