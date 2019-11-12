/*******************************************************************************
 * Copyright (c) 2019, 2019 IBM Corporation and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package com.kruize.analysis.docker;

import com.kruize.analysis.AnalysisImpl;
import com.kruize.metrics.ContainerMetrics;

public class DockerAnalysisImpl extends AnalysisImpl<ContainerMetrics>
{
    private DockerAnalysisImpl() { }

    private static DockerAnalysisImpl dockerAnalysis = null;

    static {
        getInstance();
    }

    public static DockerAnalysisImpl getInstance()
    {
        if (dockerAnalysis == null)
            dockerAnalysis = new DockerAnalysisImpl();

        return dockerAnalysis;
    }

    @Override
    public void calculateCpuRequests(ContainerMetrics container)
    {
        // Docker cannot enforce cpu requests
        double cpuRequests = -1;
        container.setCurrentCpuRequests(cpuRequests);
    }

    @Override
    public void calculateMemRequests(ContainerMetrics container, int referenceIndex, int targetIndex)
    {
        // Docker cannot enforce memory requests
        double memRequests = -1;
        container.setCurrentRssRequests(memRequests);
    }
}