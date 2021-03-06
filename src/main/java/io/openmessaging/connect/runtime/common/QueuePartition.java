/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.openmessaging.connect.runtime.common;

import java.io.Serializable;
import java.util.Objects;

/**
 * A queue name and partition number
 */
public final class QueuePartition implements Serializable {

    private int hash = 0;
    private final int partition;
    private final String queue;

    public QueuePartition(String queue, int partition) {
        this.partition = partition;
        this.queue = queue;
    }

    public int partition() {
        return partition;
    }

    public String queue() {
        return queue;
    }

    @Override
    public int hashCode() {
        if (hash != 0)
            return hash;
        final int prime = 31;
        int result = 1;
        result = prime * result + partition;
        result = prime * result + Objects.hashCode(queue);
        this.hash = result;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QueuePartition other = (QueuePartition) obj;
        return partition == other.partition && Objects.equals(queue, other.queue);
    }

    @Override
    public String toString() {
        return queue + "-" + partition;
    }
}
