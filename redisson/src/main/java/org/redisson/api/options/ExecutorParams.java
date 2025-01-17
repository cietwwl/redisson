/**
 * Copyright (c) 2013-2022 Nikita Koksharov
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
 */
package org.redisson.api.options;

import org.redisson.api.IdGenerator;
import org.redisson.client.codec.Codec;

import java.time.Duration;

/**
 *
 * @author Nikita Koksharov
 *
 */
public final class ExecutorParams extends BaseOptions<ExecutorOptions, Codec> implements ExecutorOptions {
    private final String name;
    private int taskRetryInterval = 5 * 60000;
    private IdGenerator idGenerator = IdGenerator.random();

    ExecutorParams(String name) {
        this.name = name;
    }

    @Override
    public ExecutorOptions taskRetryInterval(Duration interval) {
        this.taskRetryInterval = (int) interval.toMillis();
        return this;
    }

    @Override
    public ExecutorOptions idGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
        return this;
    }

    public String getName() {
        return name;
    }

    public int getTaskRetryInterval() {
        return taskRetryInterval;
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

}
