package bitcoin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {

	private boolean[] followees;
	private Set<Transaction> pendingTransactions = new HashSet<>();
	
    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        // IMPLEMENT THIS
    }

    public void setFollowees(boolean[] followees) {
        this.followees = followees;
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        this.pendingTransactions = pendingTransactions;
    }

    public Set<Transaction> sendToFollowers() {
        return this.pendingTransactions;
    }

    public void receiveFromFollowees(Set<Candidate> candidates) {
        for (Candidate candidate : candidates) {
        	if (this.followees[candidate.sender]) {
        		this.pendingTransactions.add(candidate.tx);
        	}
        }
    }
}