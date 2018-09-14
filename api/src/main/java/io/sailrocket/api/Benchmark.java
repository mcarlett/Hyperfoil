/*
 * Copyright 2018 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.sailrocket.api;

import java.io.Serializable;

/**
 * A benchmark is a collection of simulation, user,
 * SLA and scaling strategy (Ramp up, Steady State, Ramp Down, steady state variance)
 * that are to be run against the target environment.
 */
public class Benchmark implements Serializable {

    protected final String name;
    protected final Simulation simulation;
    protected final Host[] hosts;
    protected final SLA[] slas;

    public Benchmark(String name, Simulation simulation, Host[] hosts, SLA[] slas) {
        this.name = name;
        this.simulation = simulation;
        this.hosts = hosts;
        this.slas = slas;
    }

    public Simulation simulation() {
        return simulation;
    }

    public String name() {
        return name;
    }
}
