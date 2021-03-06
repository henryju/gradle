/*
 * Copyright 2015 the original author or authors.
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
package org.gradle.tooling.internal.provider.runner;

import org.gradle.api.Task;
import org.gradle.api.initialization.Settings;
import org.gradle.api.internal.tasks.testing.TestDescriptorInternal;
import org.gradle.api.invocation.Gradle;


public class EventIdGenerator {
    public static Object generateId(Gradle gradle) {
        return System.identityHashCode(gradle);
    }

    public static Object generateId(Task task) {
        return String.format("%s:%s", generateId(task.getProject().getGradle()), task.getPath());
    }

    public static Object generateId(TestDescriptorInternal testDescriptor) {
        return testDescriptor.getId();
    }


    public static Object generateId(Settings settings) {
        return String.format("%s:%s", generateId(settings.getGradle()), System.identityHashCode(settings));
    }

    public static Object generateId(Gradle gradle, String operationName) {
        return String.format("%s:%s", generateId(gradle), operationName);
    }
}
