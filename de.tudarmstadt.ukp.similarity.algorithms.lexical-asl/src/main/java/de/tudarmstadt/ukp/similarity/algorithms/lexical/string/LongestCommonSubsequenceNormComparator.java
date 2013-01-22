/*******************************************************************************
 * Copyright 2012
 * Ubiquitous Knowledge Processing (UKP) Lab
 * Technische Universität Darmstadt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package de.tudarmstadt.ukp.similarity.algorithms.lexical.string;

import de.tudarmstadt.ukp.similarity.algorithms.api.SimilarityException;

public class LongestCommonSubsequenceNormComparator
	extends LongestCommonSubsequenceComparator
{
	@Override
	public double getSimilarity(String string1, String string2)
		throws SimilarityException
	{
		String lcs = getLCS(string1.toLowerCase(), string2.toLowerCase());
		
		// FIXME why normalize only with the length of the first text - this is not documented
		// Normalize only by the length of the suspicious text
		double score = new Integer(lcs.length()).doubleValue() / new Integer(string1.length()).doubleValue();
		
		return score;
	}
}