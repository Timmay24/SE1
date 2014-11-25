package edu.haw.se1.sole.fragenverwaltung;

import java.util.List;

import edu.haw.se1.sole.belohnungssystem.IBadge;

public class InteractionResult<ResultType> {

	private ResultType interactionData;
	private List<IBadge> badges;

	public InteractionResult(ResultType interactionData, List<IBadge> badges) {
		this.interactionData = interactionData;
		this.badges = badges;
	}

	/**
	 * @return the interactionData
	 */
	public ResultType getInteractionData() {
		return interactionData;
	}

	/**
	 * @return the badges
	 */
	public List<IBadge> getBadges() {
		return badges;
	}
}
