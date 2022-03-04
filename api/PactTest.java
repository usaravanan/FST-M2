package com.app.demo;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.runner.RunWith;

public class PactTest {
    @RunWith(PactRunner.class)
    @Provider("provider1")
    @PactFolder("pacts")
    public class ContractTest {
        @TestTarget
        public final Target target = new HttpTarget("localhost", 8332);
    }
}
