/*
 * Copyright (c) 2013-2016, Neuro4j
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.neuro4j.flows.custom;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.neuro4j.workflow.FlowContext;

public class FlowContextTestCase {
    TestBean bean;

    @Before
    public void setUp() throws Exception {
        bean = new TestBean();
        bean.setStringVar("Hello, Mister");
    }

    @After
    public void tearDown() throws Exception {
        bean = null;

    }

    @Test
    public void testStringValueInContext() {

        FlowContext context = new FlowContext();
        context.put("var1", bean);
        Object value = context.get("var1.stringVar");
        if (value == null)
        {
            fail("Value should not be null");
        }
        if (!(value instanceof String))
        {
            fail("Wrong type");
        }
        if (!value.equals("Hello, Mister"))
        {
            fail("Wrong type");
        }
    }

    @Test
    public void testWrongKeyInContext() {

        FlowContext context = new FlowContext();
        context.put("var1", bean);
        Object value = context.get("var1.s");
        if (value != null)
        {
            fail("Value should not be null");
        }
        value = context.get("var1.");
        if (value != null)
        {
            fail("Value should not be null");
        }
    }

}
