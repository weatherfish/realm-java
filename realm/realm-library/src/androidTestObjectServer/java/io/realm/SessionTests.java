/*
 * Copyright 2016 Realm Inc.
 *
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

package io.realm;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.realm.rule.TestRealmConfigurationFactory;

import static io.realm.util.SyncTestUtils.createTestUser;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class SessionTests {

    private static String REALM_URI = "realm://objectserver.realm.io/~/default";

    private SyncConfiguration configuration;
    private SyncUser user;

    @Rule
    public final TestRealmConfigurationFactory configFactory = new TestRealmConfigurationFactory();

    @Before
    public void setUp() {
        user = createTestUser();
        configuration = new SyncConfiguration.Builder(user, REALM_URI).build();
    }

    @Test
    public void get_syncValues() {
        SyncSession session = new SyncSession(configuration);
        assertEquals("realm://objectserver.realm.io/JohnDoe/default", session.getServerUrl().toString());
        assertEquals(user, session.getUser());
        assertEquals(configuration, session.getConfiguration());
    }
}
