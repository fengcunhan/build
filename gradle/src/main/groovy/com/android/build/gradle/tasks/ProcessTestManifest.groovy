/*
 * Copyright (C) 2012 The Android Open Source Project
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
package com.android.build.gradle.tasks

import com.android.builder.ManifestDependency
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Nested

/**
 * A task that processes the manifest
 */
public class ProcessTestManifest extends ProcessManifest {

    // ----- PRIVATE TASK API -----

    @Input
    String testPackageName

    @Input
    int minSdkVersion

    @Input
    String testedPackageName

    @Input
    String instrumentationRunner

    @Nested
    List<ManifestDependency> libraries

    @Override
    protected void doFullTaskAction() {
        getBuilder().processTestManifest(
                getTestPackageName(),
                getMinSdkVersion(),
                getTestedPackageName(),
                getInstrumentationRunner(),
                getLibraries(),
                getOutManifest().absolutePath)
    }

}