/*
 * Copyright (C) 2013 The Android Open Source Project
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

package com.android.builder.testing.api;

import com.android.annotations.NonNull;
import com.android.ddmlib.IShellEnabledDevice;
import com.android.ddmlib.TimeoutException;

import java.io.File;

/**
 * A connector to a device to install/uninstall APKs, and run shell command.
 */
public abstract class DeviceConnector implements IShellEnabledDevice {

    /**
     * Establishes the connection with the device. Called before any other actions.
     * @param timeOut the time out.
     * @throws TimeoutException
     */
    public abstract void connect(int timeOut) throws TimeoutException;

    /**
     * Disconnects from the device. No other action is called afterwards.
     * @param timeOut the time out.
     * @throws TimeoutException
     */
    public abstract void disconnect(int timeOut) throws TimeoutException;

    /**
     * Installs the given APK on the device.
     * @param apkFile the APK file to install.
     * @param timeout the time out.
     * @throws DeviceException
     */
    public abstract void installPackage(@NonNull File apkFile, int timeout) throws DeviceException;

    /**
     * Uninstall the given package name from the device
     * @param packageName the package name
     * @param timeout the time out
     * @throws DeviceException
     */
    public abstract void uninstallPackage(@NonNull String packageName, int timeout) throws DeviceException;
}
