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
package io.github.tesla.ops.system.service.impl;

import java.util.List;

import io.github.tesla.authz.dao.Oauth2Dao;
import io.github.tesla.authz.domain.AccessToken;
import io.github.tesla.authz.domain.ClientDetails;
import io.github.tesla.ops.system.domain.PageDO;
import io.github.tesla.ops.system.service.Oauth2Service;
import io.github.tesla.ops.utils.Query;

/**
 * @author liushiming
 * @version Oauth2ServiceImpl.java, v 0.0.1 2018年2月5日 下午3:33:04 liushiming
 */
public class Oauth2ServiceImpl implements Oauth2Service {


  private Oauth2Dao oauth2Dao;

  @Override
  public PageDO<ClientDetails> queryClientDetailsList(Query query) {
    Integer total = oauth2Dao.countClient();
    List<ClientDetails> clients = oauth2Dao.listClient(query.getOffset(), query.getLimit());
    PageDO<ClientDetails> page = new PageDO<>();
    page.setTotal(total);
    page.setRows(clients);
    return page;
  }

  @Override
  public PageDO<AccessToken> queryTokenList(Query query) {
    Integer total = oauth2Dao.countToken();
    List<AccessToken> clients = oauth2Dao.listToken(query.getOffset(), query.getLimit());
    PageDO<AccessToken> page = new PageDO<>();
    page.setTotal(total);
    page.setRows(clients);
    return page;
  }

  @Override
  public int invokeToken(Integer tokenId) {
    return oauth2Dao.deleteAccessToken(tokenId);
  }

}