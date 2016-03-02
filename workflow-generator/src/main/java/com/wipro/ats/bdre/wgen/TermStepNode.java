/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.wipro.ats.bdre.wgen;

/**
 * Created by arijit on 12/23/14.
 */

/**
 * Methods setId, getName() and getXML() for TermStepNode
 * getXML() is formatting the string to be returned as XML format
 */

public class TermStepNode extends OozieNode {
    /**
     * This constructor is used to set id for Term Step Node
     *
     * @param id id to be set for Term Step Node
     */
    public TermStepNode(Integer id) {
        setId(id);
    }

    public String getName() {
        String termStepNodeName = "term-step-" + getId();
        return termStepNodeName.substring(0, Math.min(termStepNodeName.length(), 45));

    }

    @Override
    public String getXML() {
        return "\n<action name=\"" + getName() + "\">\n" +
                "        <java>\n" +
                "            <job-tracker>${jobTracker}</job-tracker>\n" +
                "            <name-node>${nameNode}</name-node>\n" +
                "            <main-class>com.wipro.ats.bdre.md.api.oozie.OozieTermStep</main-class>\n" +


                "            <arg>--sub-process-id</arg>\n" +
                "            <arg>" + getId() + "</arg>\n" +
                "            <capture-output />\n" +
                "        </java>\n" +
                "        <ok to=\"" + getToNode().getName() + "\"/>\n" +
                "        <error to=\"" + getTermNode().getName() + "\"/>\n" +
                "</action>";
    }
}