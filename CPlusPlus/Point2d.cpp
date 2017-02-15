/*
 * Point2d.cpp
 *
 *  Created on: Feb 4, 2017
 *      Author: Saurabh
 */

#include "Point2d.h"

namespace Quizes {

Point2d::Point2d(double x, double y)
	: m_x(x), m_y(y)
{
}

Point2d::~Point2d() {
}

void Point2d::print() {
	std::cout << "Point2d (" << this->m_x << "," << this->m_y << ")";
}

double Point2d::distanceTo(Point2d &other) {
	return sqrt((this->m_x - other.m_x)^2 + (this->m_y - other.m_y)^2);
}

} /* namespace Quizes */

using namespace Quizes;

int main() {
	Point2d x;
	Point2d y(3.0, 4.0);
	x.print();
	y.print();
}
