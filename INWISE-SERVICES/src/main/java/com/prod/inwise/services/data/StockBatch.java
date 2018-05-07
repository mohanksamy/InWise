package com.prod.inwise.services.data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;

/**
 * Entity STOCK_BATCH
 * 
 * @author Logu
 *
 */
@Entity
@Table(name = "STOCK_BATCH")
@XmlRootElement
@ApiModel
public class StockBatch extends BaseModel {
}