/*
 * Copyright ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.consensus.qbft.core.statemachine;

import org.hyperledger.besu.consensus.common.bft.ConsensusRoundIdentifier;
import org.hyperledger.besu.consensus.common.bft.events.RoundExpiry;
import org.hyperledger.besu.consensus.qbft.core.messagewrappers.Commit;
import org.hyperledger.besu.consensus.qbft.core.messagewrappers.Prepare;
import org.hyperledger.besu.consensus.qbft.core.messagewrappers.Proposal;
import org.hyperledger.besu.consensus.qbft.core.messagewrappers.RoundChange;
import org.hyperledger.besu.consensus.qbft.core.types.QbftBlockHeader;

/** The interface Base qbft block height manager. */
public interface BaseQbftBlockHeightManager {
  /**
   * Handle block timer expiry.
   *
   * @param roundIdentifier the round identifier
   */
  void handleBlockTimerExpiry(ConsensusRoundIdentifier roundIdentifier);

  /**
   * Round expired.
   *
   * @param expire the expiry
   */
  void roundExpired(RoundExpiry expire);

  /**
   * Gets chain height.
   *
   * @return the chain height
   */
  long getChainHeight();

  /**
   * Gets parent block header.
   *
   * @return the parent block header
   */
  QbftBlockHeader getParentBlockHeader();

  /**
   * Handle proposal payload.
   *
   * @param proposal the proposal
   */
  void handleProposalPayload(Proposal proposal);

  /**
   * Handle prepare payload.
   *
   * @param prepare the Prepare payload
   */
  void handlePreparePayload(Prepare prepare);

  /**
   * Handle commit payload.
   *
   * @param commit the commit payload
   */
  void handleCommitPayload(Commit commit);

  /**
   * Handle round change payload.
   *
   * @param roundChange the round change payload
   */
  void handleRoundChangePayload(RoundChange roundChange);
}
