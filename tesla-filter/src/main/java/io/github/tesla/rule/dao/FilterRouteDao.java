/*
 * Copyright 2014-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.github.tesla.rule.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import io.github.tesla.rule.domain.FilterRouteDO;

/**
 * @author liushiming
 * @version RouteDao.java, v 0.0.1 2018年1月4日 上午10:38:23 liushiming
 */
@Mapper
public interface FilterRouteDao {

  FilterRouteDO get(Long routeId);

  FilterRouteDO load(String key);

  List<FilterRouteDO> list(Map<String, Object> map);

  int count(Map<String, Object> map);

  int save(FilterRouteDO route);

  int update(FilterRouteDO route);

  int remove(Long routeId);

  int batchRemove(Long[] routeIds);

}
