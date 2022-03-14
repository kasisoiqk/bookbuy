package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class BookEntity extends BaseEntity {
	
	@Column
	private String name;
	
	@Column
	private String author;
	
	@Column
	private Long quantity;
	
	@Column
	private Long currentPrice;
	
	@Column
	private Long oldPrice;
	
	@Column
	private int sale;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "cate_id", nullable = false)
	private CategoryEntity category;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	private List<CommentEntity> comments = new ArrayList<>();

	public BookEntity() {
		super();
	}

	public BookEntity(String name, String author, Long quantity, Long currentPrice, Long oldPrice,
			String description, String image) {
		super();
		this.name = name;
		this.author = author;
		this.quantity = quantity;
		this.currentPrice = currentPrice;
		this.oldPrice = oldPrice;
		this.description = description;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(Long currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Long getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(Long oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}
	
}
