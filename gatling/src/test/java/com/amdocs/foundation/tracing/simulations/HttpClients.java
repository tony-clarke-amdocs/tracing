package com.amdocs.foundation.tracing.simulations;


import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.time.Duration;

public class HttpClients extends Simulation {
    HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:7070")
            .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // 6
            .doNotTrackHeader("1")
            .acceptLanguageHeader("en-US,en;q=0.5")
            .acceptEncodingHeader("gzip, deflate")
            .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0");

    ChainBuilder chainBuilder = forever().on(exec(http("invokeGW").get("/trace")));

    ScenarioBuilder scn = scenario("apigw").exec(chainBuilder);

    {
        setUp(scn.injectOpen(atOnceUsers(20)).protocols(httpProtocol)).maxDuration(Duration.ofMinutes(5));
    }

}
