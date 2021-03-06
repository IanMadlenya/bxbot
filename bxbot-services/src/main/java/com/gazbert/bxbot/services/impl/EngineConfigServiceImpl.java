/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Gareth Jon Lynch
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.gazbert.bxbot.services.impl;

import com.gazbert.bxbot.domain.engine.EngineConfig;
import com.gazbert.bxbot.repository.EngineConfigRepository;
import com.gazbert.bxbot.services.EngineConfigService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Implementation of the Engine config service.
 *
 * @author gazbert
 */
@Service("engineConfigService")
@Transactional
@ComponentScan(basePackages = {"com.gazbert.bxbot.repository"})
public class EngineConfigServiceImpl implements EngineConfigService {

    private static final Logger LOG = LogManager.getLogger();

    private final EngineConfigRepository engineConfigRepository;

    @Autowired
    public EngineConfigServiceImpl(EngineConfigRepository engineConfigRepository) {
        Assert.notNull(engineConfigRepository, "engineConfigRepository dependency cannot be null!");
        this.engineConfigRepository = engineConfigRepository;
    }

    @Override
    public EngineConfig getConfig() {
        return engineConfigRepository.getConfig();
    }

    @Override
    public void updateConfig(EngineConfig config) {
        LOG.info(() -> "About to update: " + config);
        engineConfigRepository.updateConfig(config);
    }
}
